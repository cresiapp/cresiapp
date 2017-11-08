<template>
  <div class="row home">
    <img src="/assets/logo.png" alt="CrESI" class="img-responsive" />

    <p class="col-md-12 slogan">Aprendé jugando</p>
    <div class="mx-auto" style="width: 100px">
      <button v-on:click="handlePlayClick" type="button" class="btn btn-secondary btn-lg">
        <span class="glyphicon glyphicon-play" aria-hidden="true"></span> Jugar
      </button>
    </div>
  </div>
</template>

<style>
.home img {
  margin: 0 auto;
  width: auto;
  height: 300px;
}

.slogan {
  color: white;
  font-size: 2em;
  text-align: center;
}
</style>


<script>
export default {
  name: 'home',
  methods: {
    handlePlayClick: function () {
      this.$emit('play-click')
    }
  }
}
</script>
