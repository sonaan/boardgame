<template>
  <PurchaseOrder />
</template>

<script>
import { defineComponent } from "vue";

// Components
import PurchaseOrder from "../components/PurchaseOrder.vue";

export default defineComponent({
  name: "PurchaseOrderView",

  components: {
    PurchaseOrder,
  },
});
</script>
