import { getRoutePath } from '../index';
const routePath = getRoutePath();

export default [
  {
    path: routePath.STATISTICSMETA,
    models: [],
    component: () => import('../routes/StatisticsMeta')
  },
  {
    path: routePath.STATISTICSMETA_LIST,
    models: [
      { namespace: 'StatisticsMeta', handle: require('../models/StatisticsMeta').default }
    ],
    component: () => import('../routes/StatisticsMeta/list')
  },
  {
    path: routePath.STATISTICSMETA_EDIT,
    models: [
      { namespace: 'StatisticsMeta', handle: require('../models/StatisticsMeta').default }
    ],
    component: () => import('../routes/StatisticsMeta/form')
  },
  {
    path: routePath.STATISTICSMETA_ADD,
    models: [
      { namespace: 'StatisticsMeta', handle: require('../models/StatisticsMeta').default }
    ],
    component: () => import('../routes/StatisticsMeta/form')
  },
]

