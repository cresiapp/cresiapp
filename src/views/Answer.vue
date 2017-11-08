<template>
  <div class="row">
    <div class="col-md-12 answer-container">
      <div v-if="answer.respondeOk" class="jumbotron alert">
        <h2>CORRECTO!</h2>
      </div>
      <div v-else class="jumbotron alert alert-danger">
        <h2>INCORRECTO!</h2>
      </div>

      <p>{{ answer.respuestaCorrecta }}</p>

      <div class="bg-success text-white rta">{{ answer.opcion.texto }}</div>

      <div class="btn-group col-md-12 navegacion">
        <a v-on:click="handleHomeClick" class="btn bg-danger text-white col" href="#">Salir</a>
        <a v-on:click="handleContinueClick" class="btn bg-success text-white col" href="#">Seguir</a>
      </div>

      <div class="jumbotron info-rta">
        <p>{{ answer.texto }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'answer',
  props: ['question', 'answer'],
  methods: {
    handleHomeClick: function () {
      this.$emit('home-click')
    },
    handleContinueClick: function () {
      this.$emit('continue-click')
    }
  }
}
</script>

