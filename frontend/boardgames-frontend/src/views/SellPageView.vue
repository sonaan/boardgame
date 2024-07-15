<template>
  <SellPage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import SellPage from "../components/SellPage.vue";

export default defineComponent({
  name: "SellPageView",

  components: {
    SellPage,
  },
});
</script>
