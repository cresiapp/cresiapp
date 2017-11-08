<template>
  <div class="row">
    <div class="col-md-12 questions-container">
      <div class="jumbotron">
        <h4>{{ question.enunciado }}</h4>
      </div>
      <button class="btn col-md-8 offset-sm-2" v-for="option in question.opciones"
        v-bind:data-id="option.id" v-bind:key="option.id" v-on:click="submitAnswer">
        {{ option.texto }}
      </button>
    </div>
  </div>
</template>

<script>
import config from './config'

export default {
  name: 'question',
  props: ['question'],
  methods: {
    submitAnswer: function (ev) {
      const answerId = ev.target.dataset["id"]
      fetch(`${config.host}/respuestas?pregunta_id=${this.question.id}&respuesta_id=${answerId}`)
        .then(res => res.json())
        .then(answer => {
          this.$emit('answer-submitted', answer)
        })
    }
  }
}
</script>


