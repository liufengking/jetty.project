//
//  ========================================================================
//  Copyright (c) 1995-2014 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.start;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.start.Props.Prop;

public class BaseHomeWarning
{
    public static void show(Props props)
    {
        Prop showWarn = props.getProp("org.eclipse.jetty.start.home.warning",true);
        if (showWarn == null || Boolean.parseBoolean(showWarn.value))
        {
            if (!Main.printTextResource("org/eclipse/jetty/start/base-home-warning.txt"))
            {
                StartLog.warn("It is not recommended to run Jetty from within {jetty.home}");
                StartLog.warn("Use a proper {jetty.base} setup");
                StartLog.warn("See: http://www.eclipse.org/jetty/documentation/current/startup.html");
            }

            try
            {
                System.err.print("Your startup will proceed shortly ...");
                TimeUnit.SECONDS.sleep(2);
                System.err.println();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}