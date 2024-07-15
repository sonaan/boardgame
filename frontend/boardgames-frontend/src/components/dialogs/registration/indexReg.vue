<template>
  <div class="text-center">
    <v-dialog v-model="dialog">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" icon> <v-icon>mdi-account-plus</v-icon> </v-btn>
      </template>
      <v-card class="mx-auto" max-width="500px" color="#9ACD32">
        <app-alert
          v-if="error"
          text="The email address is already in use by another account."
          @dismissed="onDismissed"
        ></app-alert>
        <v-card-title class="mx-auto">
          <span class="text-h6">Sign Up</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <form>
              <v-row>
                <v-col cols="12">
                  <v-text-field
                    v-model="login"
                    label="Login"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Email"
                    v-model="email"
                    variant="outlined"
                    type="email"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Password"
                    type="password"
                    v-model="password"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-radio-group v-model="sex" inline>
                    <v-radio label="Male" value="Male"></v-radio>
                    <v-radio label="Female" value="Female"></v-radio>
                  </v-radio-group>
                </v-col>
              </v-row>
            </form>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn variant="outlined" @click="close()"> Close </v-btn>
          <v-btn variant="outlined" type="submit" @click="onSignup()">
            Sing Up
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script src="./indexReg.js"></script>
