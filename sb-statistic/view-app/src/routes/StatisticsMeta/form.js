import React, { PureComponent, Fragment } from 'react';
import { injectIntl, FormattedMessage } from 'react-intl';
import { connect } from 'dva';
import Input from 'antd/lib/input';
import Form from 'antd/lib/form';

import { TitledHeader } from 'kqd-page-header';
import { GeneralForm } from 'kqd-general';
import { getRoutePath } from '../../index';

const { STATISTICSMETA_LIST } = getRoutePath();

@connect(({ StatisticsMeta, loading }) => ({
  StatisticsMeta,
  loading: loading.models.StatisticsMeta,
  submitting: loading.effects['StatisticsMeta/createForm'] || loading.effects['StatisticsMeta/updateForm']
}))
@Form.create()
export default class TheForm extends PureComponent {

  render() {
    const formProps = {
      ...this.props,
      isFooterSubmit: true,
      modelName: 'StatisticsMeta',
      REDIRECT: STATISTICSMETA_LIST,
      fields: [
        {
            'field': 'id',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'field',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'recordName',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'recordTuple',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'recordCluster',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'timeline',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'querySql',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
        {
            'field': 'tmpRecordId',
            'type': 'input',
            'intlPrefix': 'StatisticsMeta.',
            //value: 'val',
            //disabled: true,
            //options: []
        },
      ],
    }

    return (
      <TitledHeader title={<FormattedMessage id='StatisticsMeta.form.title'/>}>
        <GeneralForm {...formProps} />
      </TitledHeader>
    );
  }
}

