<template>
  <div id="map">
    <div></div>
    <div ref="mapDiv" style="width: 100%; height: 80vh" />
  </div>
</template>

<script>
//may need to disable eslint, code below doesn't work
/* eslint-disable no-undef */
import { onUnmounted, ref, onMounted } from "vue";

import { Loader } from "@googlemaps/js-api-loader";
import potholeService from "../services/PotholeService";

const GOOGLE_MAPS_API_KEY = "AIzaSyB6HPaxOw85SJRuKmwajkhRj23HVl_p6PI";

export default {
  name: "App",
  setup() {
    const loader = new Loader({ apiKey: GOOGLE_MAPS_API_KEY });
    const mapDiv = ref(null);
    let map = ref(null);
    let clickListener = null;
    const markers = []; // Store markers in this array
    const potholes = [];
    const infoWindows = [];

    const fetchPotholes = async () => {
      const response = await potholeService.listPotholesOnMap();
      potholes.push(...response.data);

      const geocoder = new google.maps.Geocoder();

      potholes.forEach((pothole) => {
        const fullAddress = `${pothole.address}, ${pothole.zipcode}`;
        geocoder.geocode({ address: fullAddress }, (results, status) => {
          if (status === "OK" && results[0].geometry) {
            const marker = new google.maps.Marker({
              position: results[0].geometry.location,
              map: map.value,
              title: fullAddress,
            });
            markers.push(marker); // Add marker to the array

            // Create InfoWindow content
            const content = `
              <div>
                <p>${pothole.address}</p>
                <img v-if="pothole.imgUrl != null" src="${pothole.imgUrl}" alt="Pothole Image" style="width: 400px; height: 400px;" />
              </div>`;

            // Create InfoWindow instance
            const infoWindow = new google.maps.InfoWindow({
              content: content,
            });

            // Attach click event listener to open InfoWindow
            marker.addListener("click", () => {
              // Close all other windows before opening a new one
              infoWindows.forEach((window) => window.close());
              infoWindow.open(map.value, marker);
            });

            infoWindows.push(infoWindow);
          }
        });
      });
    };

    onMounted(async () => {
      await loader.load();

      map.value = new google.maps.Map(mapDiv.value, {
        center: { lat: 39.1526, lng: -84.4525 }, // Center over Norwood, Ohio
        zoom: 14,
      });

      clickListener = map.value.addListener(
        "click",
        ({ latLng: { lat, lng } }) =>
          (otherPosition.value = { lat: lat(), lng: lng() })
      );

      // Fetch potholes data and then create markers
      await fetchPotholes();
    });

    onUnmounted(() => {
      if (clickListener) clickListener.remove();
    });

    return { mapDiv, markers };
  },
};
</script>


<style>
#map {
  width: 100%;
  height: 60vh;
}
</style>
