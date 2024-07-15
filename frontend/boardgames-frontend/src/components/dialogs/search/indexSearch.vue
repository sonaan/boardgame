<template>
  <div class="text-center">
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ on_search }">
        <v-btn v-on="on_search">Добавить</v-btn>
      </template>
      <v-card
        class="mx-auto"
        min-width="500px"
        max-high="300px"
        color="#9ACD32"
      >
        <v-card-title class="mx-auto">
          <span class="text-h6">Добавить игру</span>
        </v-card-title>
        <v-card-text min-width="250px">
          <v-container min-width="200px">
            <v-row>
              <v-col cols="12">
                <v-select
                  v-model="selected_gameid"
                  :items="boardgames"
                  item-title="name"
                  item-value="id"
                  variant="outlined"
                >
                </v-select>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn variant="outlined" @click="close()"> Закрыть </v-btn>
          <v-btn variant="outlined" @click="add()"> Добавить </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script src="./indexSearch.js"></script>
