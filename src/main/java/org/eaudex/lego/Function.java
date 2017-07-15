package org.eaudex.lego;

interface Function {

    double getValue(Model m);

    Model getGradient(Model m);

    Model getMiniBatchGradient(Model m, int k);

    Model getStochasticGradient(Model m);
}
