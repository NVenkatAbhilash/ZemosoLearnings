import React from 'react';
import CoffeCard from './CoffeCard';
import {Grid} from "@material-ui/core"


const Content = () => {
    return (
        <Grid container>
            <Grid xs={12} sm={4}>
                <CoffeCard />
            </Grid>
            ]
        </Grid>
    );
}

export default Content;