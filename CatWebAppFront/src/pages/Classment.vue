<script setup>
import CatClassment from "../components/CatForClassment.vue"
</script>
<template>
<header  >
    <button @click="a" />
    <CatClassment v-for="item in cats" :key="item" :Src="item.value1" :NbVote="item.value0"/>
  </header>    
</template>
<style scoped>
@import "../assets/style/PageClassment.css";
</style>
<script>
import axios from "axios";
export default {
  methods:{
    getClassment(){
      axios.get("http://localhost:8080/cat/GetAll").then((response) => {
          this.cats=response.data;
      })
    }
  },
  data(){
      return {
      cats:[],
      }
  },
  mounted(){
      this.getClassment();
  }
}
</script>