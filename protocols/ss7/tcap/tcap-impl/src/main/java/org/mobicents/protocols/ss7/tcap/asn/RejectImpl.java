/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 * 
 */
package org.mobicents.protocols.ss7.tcap.asn;

import java.io.IOException;

import org.mobicents.protocols.asn.AsnException;
import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.asn.Tag;
import org.mobicents.protocols.ss7.tcap.asn.comp.ComponentType;
import org.mobicents.protocols.ss7.tcap.asn.comp.Problem;
import org.mobicents.protocols.ss7.tcap.asn.comp.ProblemType;
import org.mobicents.protocols.ss7.tcap.asn.comp.Reject;

/**
 * @author baranowb
 * 
 */
public class RejectImpl implements Reject {

	// all are mandatory

	// this can actaully be null in this case.
	private Long invokeId;

	private Problem problem;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mobicents.protocols.ss7.tcap.asn.comp.Reject#getInvokeId()
	 */
	public Long getInvokeId() {

		return this.invokeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mobicents.protocols.ss7.tcap.asn.comp.Reject#getProblem()
	 */
	public Problem getProblem() {

		return this.problem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.protocols.ss7.tcap.asn.comp.Reject#setInvokeId(java.lang
	 * .Long)
	 */
	public void setInvokeId(Long i) {
		if (i != null && (i < -128 || i > 127)) {
			throw new IllegalArgumentException("Invoke ID our of range: <-128,127>: " + i);
		}
		this.invokeId = i;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.protocols.ss7.tcap.asn.comp.Reject#setProblem(org.mobicents
	 * .protocols.ss7.tcap.asn.comp.Problem)
	 */
	public void setProblem(Problem p) {

		this.problem = p;

	}

	public ComponentType getType() {

		return ComponentType.Reject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.protocols.ss7.tcap.asn.Encodable#decode(org.mobicents.protocols
	 * .asn.AsnInputStream)
	 */
	public void decode(AsnInputStream ais) throws ParseException {

		try {
			int len = ais.readLength();
			if (len == 0x80) {
				throw new ParseException("Undefined length is not supported.");
			}
			if (len > ais.available()) {
				throw new ParseException("Not enough data.");
			}
			int tag = ais.readTag();
			if (tag == _TAG_IID) {
				this.invokeId = ais.readInteger();
				tag = ais.readTag();
			} else if (tag == Tag.NULL) {
				// its ok, read len
				ais.readLength();
				tag = ais.readTag();
			}

			ProblemType pt = ProblemType.getFromInt(tag);
			this.problem = TcapFactory.createProblem(pt, ais);
		} catch (IOException e) {
			throw new ParseException(e);
		} catch (AsnException e) {
			throw new ParseException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.protocols.ss7.tcap.asn.Encodable#encode(org.mobicents.protocols
	 * .asn.AsnOutputStream)
	 */
	public void encode(AsnOutputStream aos) throws ParseException {

		if (this.problem == null) {
			throw new ParseException("Problem not set!");
		}
		try {
			AsnOutputStream localAos = new AsnOutputStream();

			if (this.invokeId == null) {
				localAos.writeTag(Tag.CLASS_UNIVERSAL, true, Tag.NULL);
				localAos.writeLength(0x00);
			} else {

				localAos.writeInteger(_TAG_IID_CLASS, _TAG_IID, this.invokeId);

			}
			this.problem.encode(localAos);
			byte[] data = localAos.toByteArray();
			aos.writeTag(_TAG_CLASS, _TAG_PC_PRIMITIVE, _TAG);
			aos.writeLength(data.length);
			aos.write(data);
		} catch (IOException e) {
			throw new ParseException(e);
		}

	}

}