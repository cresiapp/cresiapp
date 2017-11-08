<template>
  <div class="row header">
    <img src="/assets/logo.png" alt="Cresi">
  </div>
</template>

<style>
.header {
  background-image: url('/assets/header-bg.png');
  background-size: cover;
  height: 15vh;
  margin-bottom: 3vh;
}

.header > img {
  width: 20%;
  align-self: center;
}
</style>

<script>
export default {
  name: 'topbar'
}
</script>
