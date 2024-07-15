<template>
  <BoardGames />
</template>

<script>
import { defineComponent } from "vue";

// Components
import BoardGames from "../components/BoardGames.vue";

export default defineComponent({
  name: "BoardGamesView",

  components: {
    BoardGames,
  },
});
</script>
