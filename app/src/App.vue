<template>
  <div id="app" class="container">
    <div class="sticky">
    <topbar v-if="page !== 'home'"></topbar>
    </div>
    <div class="scrollable">
      <home v-if="page === 'home'" @play-click="handlePlayClick"></home>
      <roulette v-if="page === 'roulette'" v-on:question-selected="handleSelectedQuestion"></roulette>
      <question v-if="page === 'question'" v-bind:question="question" v-on:answer-submitted="handleSubmittedAnswer"></question>
      <answer v-if="page === 'answer'" v-bind:question="question" v-bind:answer="answer" @home-click="handleHomeClick" @continue-click="handleContinueClick"></answer>
    </div>
  </div>
 </template>

<script>
import Topbar from './Topbar.vue'
import Home from './Home.vue'
import Roulette from './Roulette.vue'
import Question from './Question.vue'
import Answer from './Answer.vue'

export default {
  name: 'app',
  data: () => ({
    page: 'home'
  }),
  methods: {
    handlePlayClick: function () {
      this.page = 'roulette'
    },
    handleSelectedQuestion: function (question) {
      this.question = question
      this.page = 'question'
    },
    handleSubmittedAnswer: function (answer) {
      this.answer = answer
      this.page = 'answer'
    },
    handleHomeClick: function () {
      this.answer = this.question = undefined
      this.page = 'home'
    },
    handleContinueClick: function () {
      this.answer = this.question = undefined
      this.page = 'roulette'
    }
  },
  components: {
    Topbar,
    Home,
    Roulette,
    Question,
    Answer
  }
}
</script>

<style>
html {
  font-size: 100%;
}

.texto-blanco {
  color: white;
  font-size: 2em;
}

.header {
  background-image: url('/assets/header-bg.png');
  background-size: cover;
  height: 15vh;
  margin-bottom: 3vh;
}

.header img {
  width: 20%;
  align-self: center;
}

.roulette-container {
  text-align: center;
  margin-top: 10vh;
  background-color: #4CB9FF;
}

.roulette {
  width: 100%;
  max-width: 600px;
}

.roulette.frame {
  display: none;
  margin: 0 auto;
}

.roulette.frame.visible {
  display: block;
}

.category-legend {
  margin-top: 30px;
}

.container {
  background-color: #4CB9FF;
  min-height: 100vh;
}


.questions-container button {
  cursor: pointer;
  margin-bottom: 10px;
  text-align: center;
  white-space: normal;
}

.questions-container .jumbotron {
  background-color:#FFA500;
  text-align: center;
  color: white;
}

.answer-container p {
  text-align: center;
}

.answer-container .rta {
  margin-bottom: 20px;
  padding: 20px;
}

.navegacion {
  margin-bottom: 20px;
}

.info-rta {
  background-color: white;
  color: black;
}

.navegacion {
  text-transform: uppercase;
}

.home img {
  margin:0 auto;
  width: auto;
  height: 300px;
}

.home p {
  text-align: center;
}
</style>
