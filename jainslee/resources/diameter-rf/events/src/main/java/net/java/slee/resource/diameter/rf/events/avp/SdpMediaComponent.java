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
package net.java.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the SDP-Media-Component grouped AVP type.<br> 
 * <br>
 * From the Diameter Rf Reference Point Protocol Details (3GPP TS 32.299 V7.1.0) specification:
 * <pre> 
 * 7.2.95 SDP-Media-Component AVP 
 *  The SDP-Media-Component AVP (AVP code 843) is of type Grouped and contains information about media used for a IMS
 *  session. 
 *  
 *  It has the following ABNF grammar: 
 *   SDP-Media-Component ::= AVP Header: 843 
 *      [ SDP-Media-Name ] 
 *    * [ SDP-Media-Description ] 
 *      [ Media-Initiator-Flag] 
 *      [ Authorized-QoS ] 
 *      [ TGPP-Charging-Id ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface SdpMediaComponent extends GroupedAvp {

  /**
   * Returns the value of the Authorized-QoS AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  abstract String getAuthorizedQos();

  /**
   * Returns the value of the Media-Initiator-Flag AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
   */
  abstract MediaInitiatorFlag getMediaInitiatorFlag();

  /**
   * Returns the set of SDP-Media-Description AVPs. The returned array contains the AVPs in the order they appear in the message. A return value of null implies that no SDP-Media-Description AVPs have been set. The elements in the given array are String objects.
   */
  abstract String[] getSdpMediaDescriptions();

  /**
   * Returns the value of the SDP-Media-Name AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  abstract String getSdpMediaName();

  /**
   * Returns the value of the TGPP-Charging-Id AVP, of type OctetString. A return value of null implies that the AVP has not been set.
   */
  abstract String getTgppChargingId();

  /**
   * Returns true if the Authorized-QoS AVP is present in the message.
   */
  abstract boolean hasAuthorizedQos();

  /**
   * Returns true if the Media-Initiator-Flag AVP is present in the message.
   */
  abstract boolean hasMediaInitiatorFlag();

  /**
   * Returns true if the SDP-Media-Name AVP is present in the message.
   */
  abstract boolean hasSdpMediaName();

  /**
   * Returns true if the TGPP-Charging-Id AVP is present in the message.
   */
  abstract boolean hasTgppChargingId();

  /**
   * Sets the value of the Authorized-QoS AVP, of type UTF8String.
   */
  abstract void setAuthorizedQos(String authorizedQos);

  /**
   * Sets the value of the Media-Initiator-Flag AVP, of type Enumerated.
   */
  abstract void setMediaInitiatorFlag(MediaInitiatorFlag mediaInitiatorFlag);

  /**
   * Sets a single SDP-Media-Description AVP in the message, of type UTF8String.
   */
  abstract void setSdpMediaDescription(String sdpMediaDescription);

  /**
   * Sets the set of SDP-Media-Description AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array. Note: the array must not be altered by the caller following this call, and getSdpMediaDescriptions() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
   */
  abstract void setSdpMediaDescriptions(String[] sdpMediaDescriptions);

  /**
   * Sets the value of the SDP-Media-Name AVP, of type UTF8String.
   */
  abstract void setSdpMediaName(String sdpMediaName);

  /**
   * Sets the value of the TGPP-Charging-Id AVP, of type OctetString.
   */
  abstract void setTgppChargingId(String tgppChargingId);

}