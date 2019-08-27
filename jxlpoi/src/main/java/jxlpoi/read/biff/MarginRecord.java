/*********************************************************************
*
*      Copyright (C) 2002 Andrew Khan
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
***************************************************************************/

package jxlpoi.read.biff;

import jxlpoi.biff.DoubleHelper;
import jxlpoi.biff.RecordData;
import jxlpoi.biff.Type;

/**
 * Abstract class containing the margin value for top,left,right and bottom
 * margins
 */
abstract class MarginRecord extends RecordData
{
  /**
   * The size of the margin
   */
  private double margin;

  /**
   * Constructs this record from the raw data
   *
   * @param t the type
   * @param r the record
   */
  protected MarginRecord(Type t, Record r)
  {
    super(t);

    byte[] data = r.getData();

    margin = DoubleHelper.getIEEEDouble(data, 0);
  }

  /**
   * Accessor for the margin
   *
   * @return the margin
   */
  double getMargin()
  {
    return margin;
  }
}
