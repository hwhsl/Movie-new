
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import MovieManager from "./components/listers/MovieCards"
import MovieDetail from "./components/listers/MovieDetail"
import ReviewManager from "./components/listers/ReviewCards"
import ReviewDetail from "./components/listers/ReviewDetail"

import ReservationManager from "./components/listers/ReservationCards"
import ReservationDetail from "./components/listers/ReservationDetail"

import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import MessageManager from "./components/listers/MessageCards"
import MessageDetail from "./components/listers/MessageDetail"


import MovieViewView from "./components/MovieViewView"
import MovieViewViewDetail from "./components/MovieViewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/movies',
                name: 'MovieManager',
                component: MovieManager
            },
            {
                path: '/movies/:id',
                name: 'MovieDetail',
                component: MovieDetail
            },
            {
                path: '/reviews',
                name: 'ReviewManager',
                component: ReviewManager
            },
            {
                path: '/reviews/:id',
                name: 'ReviewDetail',
                component: ReviewDetail
            },

            {
                path: '/reservations',
                name: 'ReservationManager',
                component: ReservationManager
            },
            {
                path: '/reservations/:id',
                name: 'ReservationDetail',
                component: ReservationDetail
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/messages',
                name: 'MessageManager',
                component: MessageManager
            },
            {
                path: '/messages/:id',
                name: 'MessageDetail',
                component: MessageDetail
            },


            {
                path: '/movieViews',
                name: 'MovieViewView',
                component: MovieViewView
            },
            {
                path: '/movieViews/:id',
                name: 'MovieViewViewDetail',
                component: MovieViewViewDetail
            },


    ]
})
