<script setup>
defineProps({
  CatName: {
    type: String,
    required: true,
  },
  Tmp:{
    type: String,
    required: true,
  }
});
</script>
<template>
  <div id="Content">
    <h1 class="titre">{{CatName}}</h1>
    <div class="col-size">
    <div class="vert-center">
    <p @click="send()">{{Tmp}}</p>
    </div>
    </div>
  </div>
</template>
<script>
export default {
    methods:{
        send(){
            console.log(this.Tmp)
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
