import React from 'react';
import {Grid} from "@material-ui/core";
import Header from './Header';
import Content from './Content';

const SampleApp = (props) => {
    return (
        <Grid container direction="column">
            <Grid item>
                <Header />
            </Grid>
            <Grid item container>
              <Grid item sm={2} xs={0} />
              <Grid item sm={8} xs={12}>
                <Content />
              </Grid>
              <Grid item sm={2} xs={0} />
            </Grid>
          </Grid>
    );
}

export default SampleApp;