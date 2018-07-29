import { baseModel, modelExtend } from 'kqd-general';
import { query, get, update, remove, patch, createRaw } from 'kqd-utils/lib/services';

export default modelExtend(baseModel, {
  namespace: 'StatisticsMeta',
  state: {
    API: '/api/StatisticsMeta'
  },
  effects: {
    *demoQuery({ payload }, { call, put }) {
      console.log("demoQuery");
      const { API } = payload;
      delete payload.API;
      const result = yield call(query, API, { ...payload });

    },
  }
});

