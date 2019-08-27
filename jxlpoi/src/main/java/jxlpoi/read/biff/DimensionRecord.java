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

import jxlpoi.biff.IntegerHelper;
import jxlpoi.biff.RecordData;
import jxlpoi.common.Logger;

/**
 * Contains the cell dimensions of this worksheet
 */
class DimensionRecord extends RecordData
{
  /**
   * The logger
   */
  private static Logger logger = Logger.getLogger(DimensionRecord.class);

  /**
   * The number of rows in this sheet
   */
  private int numRows;
  /**
   * The number of columns in this worksheet
   */
  private int numCols;

  /**
   * Dummy indicators for overloading the constructor
   */
  private static class Biff7 {};
  public static Biff7 biff7 = new Biff7();

  /**
   * Constructs the dimensions from the raw data
   *
   * @param t the raw data
   */
  public DimensionRecord(Record t)
  {
    super(t);
    byte[] data = t.getData();

    // Sometimes, if the spreadsheet is being generated by dodgy VB modules,
    // even though the excel format is biff8, the dimension record is
    // generated in the old biff 7 format.  This horrible if construct
    // handles that eventuality
    if (data.length == 10)
    {
      read10ByteData(data);
    }
    else
    {
      read14ByteData(data);
    }
  }

  /**
   * Constructs the dimensions from the raw data
   *
   * @param t the raw data
   * @param biff7 an indicator to initialise this record for biff 7 format
   */
  public DimensionRecord(Record t, Biff7 biff7)
  {
    super(t);
    byte[] data = t.getData();
    read10ByteData(data);
  }

  /**
   * Reads in the data for data records of length 10
   * @param data the data to read
   */
  private void read10ByteData(byte[] data)
  {
    numRows = IntegerHelper.getInt(data[2], data[3]);
    numCols = IntegerHelper.getInt(data[6], data[7]);
  }

  /**
   * Reads in the data for data records of length 14
   * @param data the data to read
   */
  private void read14ByteData(byte[] data)
  {
    numRows = IntegerHelper.getInt(data[4], data[5], data[6], data[7]);
    numCols = IntegerHelper.getInt(data[10], data[11]);
  }

  /**
   * Accessor for the number of rows in this sheet
   *
   * @return the number of rows
   */
  public int getNumberOfRows()
  {
    return numRows;
  }

  /**
   * Accessor for the number of columns in this sheet
   *
   * @return the number of columns
   */
  public int getNumberOfColumns()
  {
    return numCols;
  }
}







