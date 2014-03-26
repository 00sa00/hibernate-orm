/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.source.internal.hbm;

import org.hibernate.AssertionFailure;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.metamodel.source.internal.jaxb.hbm.JaxbMapElement;
import org.hibernate.metamodel.source.spi.AttributeSourceContainer;
import org.hibernate.metamodel.source.spi.IndexedPluralAttributeSource;
import org.hibernate.metamodel.source.spi.PluralAttributeIndexSource;
import org.hibernate.metamodel.spi.PluralAttributeNature;

public class MapSourceImpl extends AbstractPluralAttributeSourceImpl implements IndexedPluralAttributeSource {
	private final PluralAttributeIndexSource indexSource;

	public MapSourceImpl(
			MappingDocument sourceMappingDocument,
			JaxbMapElement mapElement,
			AttributeSourceContainer container) {
		super( sourceMappingDocument, mapElement, container );
		if (  mapElement.getMapKey() != null ) {
			this.indexSource = new MapKeySourceBasicImpl( sourceMappingDocument,  mapElement.getMapKey() );
		}
		else if ( mapElement.getIndex() != null ) {
			this.indexSource = new MapKeySourceBasicImpl( sourceMappingDocument, mapElement.getIndex() );
		}
		else if ( mapElement.getCompositeMapKey() != null ) {
			this.indexSource = new PluralAttributeMapKeySourceEmbeddedImpl(
					sourceMappingDocument,
					this,
					mapElement.getCompositeMapKey()
			);
		}
		else if ( mapElement.getCompositeIndex() != null ) {
			this.indexSource = new PluralAttributeMapKeySourceEmbeddedImpl(
					sourceMappingDocument,
					this,
					mapElement.getCompositeIndex()
			);
		}
		else if ( mapElement.getMapKeyManyToMany() != null ) {
			throw new NotYetImplementedException( "<map-key-many-to-many> is not supported yet" );
		}
		else if ( mapElement.getIndexManyToMany() != null ) {
			throw new NotYetImplementedException( "<index-many-to-many> is not supported yet" );
		}
		else if ( mapElement.getIndexManyToAny() != null ) {
			throw new NotYetImplementedException( "<index-many-to-any> is not supported yet" );
		}
		else {
			throw new AssertionFailure( "No map key found" );
		}
	}

	@Override
	public PluralAttributeIndexSource getIndexSource() {
		return indexSource;
	}

	@Override
	public JaxbMapElement getPluralAttributeElement() {
		return ( JaxbMapElement ) super.getPluralAttributeElement();
	}

	@Override
	public PluralAttributeNature getNature() {
		return PluralAttributeNature.MAP;
	}
}
