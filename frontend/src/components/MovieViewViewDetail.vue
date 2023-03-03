<template>

    <v-card outlined>
        <v-card-title>
            MovieView # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="MovieId" v-model="item.movieId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Title" v-model="item.title" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Count" v-model="item.count" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MovieStatus" v-model="item.movieStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReservationStatus" v-model="item.reservationStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReservationId" v-model="item.reservationId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PaymentId" v-model="item.paymentId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PaymentStatus" v-model="item.paymentStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MovieViewViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/movieViews/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

