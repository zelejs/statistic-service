import React, { PureComponent } from 'react';
import { injectIntl, FormattedMessage } from 'react-intl';
import { connect } from 'dva';

import { WhiteSpace } from 'kqd-common';
import { TitledHeader } from 'kqd-page-header';
import { GeneralList } from 'kqd-general';

import { getRoutePath } from '../../index';

const { STATISTICSMETA_ADD, STATISTICSMETA_EDIT } = getRoutePath();

@connect(({ StatisticsMeta, loading }) => ({
  StatisticsMeta,
  loading: loading.models.StatisticsMeta,
}))
export default class List extends PureComponent {

  render() {
    const listProps = {
      ...this.props,
      modelName: 'StatisticsMeta',
      ADD: STATISTICSMETA_ADD,
      EDIT: STATISTICSMETA_EDIT,
      dataColumns: [
        {
          title: 'id',
          dataIndex: 'id',
        },
        {
          title: 'field',
          dataIndex: 'field',
        },
        {
          title: 'recordName',
          dataIndex: 'recordName',
        },
        {
          title: 'recordTuple',
          dataIndex: 'recordTuple',
        },
        {
          title: 'recordCluster',
          dataIndex: 'recordCluster',
        },
        {
          title: 'timeline',
          dataIndex: 'timeline',
        },
        {
          title: 'querySql',
          dataIndex: 'querySql',
        },
        {
          title: 'tmpRecordId',
          dataIndex: 'tmpRecordId',
        },
      ],
      // search box
      fields: [
        { field: 'id', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'field', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'recordName', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'recordTuple', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'recordCluster', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'timeline', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'querySql', type: 'input', intlPrefix: 'StatisticsMeta.' },
        { field: 'tmpRecordId', type: 'input', intlPrefix: 'StatisticsMeta.' },
      ],
    }

    return (
      <TitledHeader title={<FormattedMessage id='StatisticsMeta.list.title'/>}>
        <GeneralList {...listProps} />
      </TitledHeader>
    );
  }
}

