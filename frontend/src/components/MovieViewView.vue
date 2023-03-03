<template>

    <v-data-table
        :headers="headers"
        :items="movieView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MovieViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "movieId", value: "movieId" },
                { text: "title", value: "title" },
                { text: "count", value: "count" },
                { text: "movieStatus", value: "movieStatus" },
                { text: "reservationStatus", value: "reservationStatus" },
                { text: "reservationId", value: "reservationId" },
                { text: "paymentId", value: "paymentId" },
                { text: "paymentStatus", value: "paymentStatus" },
            ],
            movieView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/movieViews'))

            temp.data._embedded.movieViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.movieView = temp.data._embedded.movieViews;
        },
        methods: {
        }
    }
</script>

