<script setup>
defineProps({
  Src:{
    type: String,
    required: true,
  },
  NbVote:{
      type:Number,
      required: true
  }
});
</script>
<style>
@import "../assets/style/PageClassment.css";
</style>
<template>
  <div class="classment" >
      <img width="150" height="100" :src="Src"/>
      <p class="Vote">{{NbVote}}</p>
  </div>
</template>