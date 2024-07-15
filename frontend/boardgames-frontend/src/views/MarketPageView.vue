<template>
  <MarketPage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import MarketPage from "../components/MarketPage.vue";

export default defineComponent({
  name: "MarketPageView",

  components: {
    MarketPage,
  },
});
</script>
