export default {
    'GET /api/StatisticsMeta': (req, res) => {
      res.send({
        code: 200,
        data: {
          total: 4,
          current: 1,
          records: [
                        {
                                'id': '1',
                                'field': '1',
                                'recordName': '1',
                                'recordTuple': '1',
                                'recordCluster': '1',
                                'timeline': '1',
                                'querySql': '1',
                                'tmpRecordId': '1',
                            },
                        {
                                'id': '1',
                                'field': '1',
                                'recordName': '1',
                                'recordTuple': '1',
                                'recordCluster': '1',
                                'timeline': '1',
                                'querySql': '1',
                                'tmpRecordId': '1',
                            },
                        {
                                'id': '1',
                                'field': '1',
                                'recordName': '1',
                                'recordTuple': '1',
                                'recordCluster': '1',
                                'timeline': '1',
                                'querySql': '1',
                                'tmpRecordId': '1',
                            },
                        {
                                'id': '1',
                                'field': '1',
                                'recordName': '1',
                                'recordTuple': '1',
                                'recordCluster': '1',
                                'timeline': '1',
                                'querySql': '1',
                                'tmpRecordId': '1',
                            },
                      ]
        }
      });
    },

    'GET /api/StatisticsMeta/*': (req, res) => {
      res.send({
        code: 200,
        data: {
                        'id': '1',
                        'field': '1',
                        'recordName': '1',
                        'recordTuple': '1',
                        'recordCluster': '1',
                        'timeline': '1',
                        'querySql': '1',
                        'tmpRecordId': '1',
                    }
      });
    },

    'POST /api/StatisticsMeta': (req, res) => {
      res.send({
        code: 200,
        message: 'success'
      });
    },

    'PUT /api/StatisticsMeta/*': (req, res) => {
      res.send({
        code: 200,
        message: 'success'
      });
    },

    'DELETE /api/StatisticsMeta/*': (req, res) => {
      res.send({
        code: 200,
        message: 'success'
      });
    },
}

