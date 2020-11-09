import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Layout from '@/components/Layout'
import RelevanceForm from '../components/RelevanceForm'
import RelavanceTable from '../components/RelevanceTable'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Layout',
      component: Layout
    },
    {
      path: '/relevance',
      name: 'RelevanceForm',
      component: RelevanceForm
    },
    {
      path: '/relevance_table',
      name: 'RelavanceTable',
      component: RelavanceTable
    }
  ]
})
