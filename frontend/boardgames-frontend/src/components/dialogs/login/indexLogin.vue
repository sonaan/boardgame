<template>
  <div class="text-center">
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" icon> <v-icon>mdi-login-variant</v-icon> </v-btn>
      </template>
      <v-card class="mx-auto" color="#9ACD32">
        <app-alert
          v-if="error"
          text="The email address or password is wrong."
          @dismissed="onDismissed"
        ></app-alert>
        <v-card-title class="mx-auto">
          <span class="text-h6">Sign In</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field
                  label="Email"
                  v-model="email"
                  variant="outlined"
                  type="email"
                  size="15"
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="Password"
                  type="password"
                  v-model="password"
                  size="15"
                  variant="outlined"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn variant="outlined" @click="close()"> Close </v-btn>
          <v-btn variant="outlined" @click="onSignin()"> Sing In </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script src="./indexLogin.js"></script>
