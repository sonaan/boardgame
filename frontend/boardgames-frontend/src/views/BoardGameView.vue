<template>
  <BoardGame />
</template>

<script>
import { defineComponent } from "vue";

// Components
import BoardGame from "../components/BoardGame.vue";

export default defineComponent({
  name: "BoardGameView",

  components: {
    BoardGame,
  },
});
</script>
