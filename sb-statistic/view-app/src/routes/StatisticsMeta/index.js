import React, { PureComponent } from 'react';
import { Route, Redirect, Switch } from 'dva/router';

import { getRoutes } from 'kqd-general';
import { PageHeader } from 'kqd-page-header';

import { getRoutePath } from '../../index';
const { STATISTICSMETA, STATISTICSMETA_LIST } = getRoutePath();

export default class Index extends PureComponent {

  render() {
    const { match, routerData } = this.props;

    return (
        <PageHeader>
          <Switch>
            {
              getRoutes(match.path, routerData).map(item => (
                <Route
                  key={item.key}
                  path={item.path}
                  component={item.component}
                  exact={item.exact}
                />
              ))
            }
            <Redirect exact from={STATISTICSMETA} to={STATISTICSMETA_LIST} />
          </Switch>
        </PageHeader>
    );
  }
}

