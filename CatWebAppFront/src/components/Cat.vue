<script setup>
defineProps({
  CatName: {
    type: String,
    required: true,
  },
  Src:{
    type: String,
    required: true,
  },
  ID:{
      type:String,
      required: true
  }
});
</script>
<template>
  <div id="Content">
    <h1 class="titre">{{CatName}}</h1>
    <div class="col-size">
    <div class="vert-center">
        <img @click="send()" width="250" height="250" :src="Src"/>
    </div>
    </div>
  </div>
</template>
<script>
import axios from "axios"
export default {
    methods:{
        send(){
            
            console.log("vote");
            axios.request("http://localhost:8080/cat/VoteCat/"+this.ID);
            this.$emit("update");
            
        }
    }
}
/*<img
      alt="Vue logo"
      class="logo"
      src="./assets/logo.svg"
      width="125"
      height="125"
    />
    */
</script>
<style scoped>
@import '../assets/style/CatComponent.css' 
</style>
