<template>
  <div class="text-center">
    <v-dialog v-model="dialogmessage">
      <v-card
        class="mx-auto"
        min-width="500px"
        max-high="300px"
        color="#9ACD32"
      >
        <v-card-title class="mx-auto">
          <span class="text-h6">Отправить сообщение {{ userloginsend }}</span>
        </v-card-title>
        <v-card-text min-width="250px">
          <v-textarea
            counter
            label="Сообщение"
            v-model="message"
            variant="outlined"
          ></v-textarea>
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

<script src="./indexMessage.js"></script>
