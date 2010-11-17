/*
 * JBoss, Home of Professional Open Source
 * 
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.ro.events.avp.AddressDomain;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * 
 * AddressDomainImpl.java
 *
 * <br>Project:  mobicents
 * <br>12:52:48 AM Apr 11, 2009 
 * <br>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class AddressDomainImpl extends GroupedAvpImpl implements AddressDomain {

  public AddressDomainImpl() {
    super();
  }

  /**
   * 
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public AddressDomainImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super( code, vendorId, mnd, prt, value );
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#getDomainName()
   */
  public String getDomainName() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.DOMAIN_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#getTgppImsiMccMnc()
   */
  public byte[] getTgppImsiMccMnc() {
    return getAvpAsRaw(DiameterRoAvpCodes.TGPP_IMSI_MCC_MNC, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#hasDomainName()
   */
  public boolean hasDomainName() {
    return hasAvp(DiameterRoAvpCodes.DOMAIN_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#hasTgppImsiMccMnc()
   */
  public boolean hasTgppImsiMccMnc() {
    return hasAvp(DiameterRoAvpCodes.TGPP_IMSI_MCC_MNC, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#setDomainName(String)
   */
  public void setDomainName(String domainName) {
    addAvp(DiameterRoAvpCodes.DOMAIN_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID, domainName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.AddressDomain#setTgppImsiMccMnc(byte[])
   */
  public void setTgppImsiMccMnc(byte[] tgppImsiMccMnc)
  {
    addAvp(DiameterRoAvpCodes.TGPP_IMSI_MCC_MNC, DiameterRoAvpCodes.TGPP_VENDOR_ID, tgppImsiMccMnc);
  }

}