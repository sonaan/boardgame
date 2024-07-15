<template>
  <v-alert type="error" variant="outlined" closable @click="onClose">
    {{ text }}
  </v-alert>
</template>

<script>
export default {
  props: ["text"],

  methods: {
    onClose() {
      this.$emit("dismissed");
    },
  },
};
</script>
