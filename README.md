Brooklyn MODAClouds
==================
[![Build Status](https://api.travis-ci.org/SeaCloudsEU/brooklyn-modaclouds.svg?branch=master)](https://travis-ci.org/SeaCloudsEU/brooklyn-modaclouds)

## Building and Running

There are several options available for building and running.

### Building a standlone distro

To build an assembly, simply run:

    mvn clean install

This creates a tarball with a full standalone application which can be installed in any *nix machine at:
    target/brooklyn-modaclouds-dist.tar.gz

It also installs an unpacked version which you can run locally:

     cd target/brooklyn-modaclouds-dist/brooklyn-modaclouds/
     ./start.sh launch

For more information see the README (or `./start.sh help`) in that directory.

To configure cloud and fixed-IP locations, see the README file in the built application directly.
For more information you can run `./start.sh help`) in that directory.


### Adding to Brooklyn dropins

An alternative is to build a single jar and to add that to an existing Brooklyn install.

First install Brooklyn. There are instructions at https://brooklyn.incubator.apache.org/v/latest/start/index.html

Then simply run:

    mvn clean install

You can copy the jar to your Brooklyn dropins folder, and then launch Brooklyn:

    cp target/brooklyn-modaclouds-0.1-SNAPSHOT.jar $BROOKLYN_HOME/lib/dropins/
    nohup $BROOKLYN_HOME/bin/brooklyn launch &

Contributing
-------------
If you want to help us with the development of this project please read carefully our [**Contributing Guide**](CONTRIBUTING.md).


##License##
Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
