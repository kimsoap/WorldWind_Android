/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */
package gov.nasa.worldwind.globes;

import gov.nasa.worldwind.*;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.terrain.*;
import gov.nasa.worldwind.util.WWUtil;

/**
 * @author dcollins
 * @version $Id: Earth.java 733 2012-09-02 17:15:09Z dcollins $
 */
public class Earth extends EllipsoidalGlobe
{
    public static final double WGS84_EQUATORIAL_RADIUS = 6378137.0; // ellipsoid equatorial getRadius, in meters
    protected static final double WGS84_POLAR_RADIUS = 6356752.3; // ellipsoid polar getRadius, in meters
    protected static final double WGS84_ES = 0.00669437999013; // eccentricity squared, semi-major axis

    public static final double ELEVATION_MIN = -11000d; // Depth of Marianas trench
    public static final double ELEVATION_MAX = 8500d; // Height of Mt. Everest.
    
    
    public Earth()
    {
        super(WGS84_EQUATORIAL_RADIUS, WGS84_POLAR_RADIUS, WGS84_ES, createElevationModel());
    }

    protected static ElevationModel createElevationModel()
    {
        String configFile = Configuration.getStringValue(AVKey.EARTH_ELEVATION_MODEL_CONFIG_FILE);
        if (WWUtil.isEmpty(configFile))
            return new ZeroElevationModel();

        return (ElevationModel) BasicFactory.create(AVKey.ELEVATION_MODEL_FACTORY, configFile);
    }

    public String toString()
    {
        return "Earth";
    }
}
