/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package vng.luchm.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-04-11")
public class FriendLists implements org.apache.thrift.TBase<FriendLists, FriendLists._Fields>, java.io.Serializable, Cloneable, Comparable<FriendLists> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FriendLists");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("UserId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ACTION_USER_FIELD_DESC = new org.apache.thrift.protocol.TField("ActionUser", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FriendListsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FriendListsTupleSchemeFactory());
  }

  public String UserId; // required
  public int Status; // required
  public String ActionUser; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "UserId"),
    STATUS((short)2, "Status"),
    ACTION_USER((short)3, "ActionUser");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_ID
          return USER_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // ACTION_USER
          return ACTION_USER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __STATUS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("UserId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ACTION_USER, new org.apache.thrift.meta_data.FieldMetaData("ActionUser", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FriendLists.class, metaDataMap);
  }

  public FriendLists() {
  }

  public FriendLists(
    String UserId,
    int Status,
    String ActionUser)
  {
    this();
    this.UserId = UserId;
    this.Status = Status;
    setStatusIsSet(true);
    this.ActionUser = ActionUser;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FriendLists(FriendLists other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetUserId()) {
      this.UserId = other.UserId;
    }
    this.Status = other.Status;
    if (other.isSetActionUser()) {
      this.ActionUser = other.ActionUser;
    }
  }

  public FriendLists deepCopy() {
    return new FriendLists(this);
  }

  @Override
  public void clear() {
    this.UserId = null;
    setStatusIsSet(false);
    this.Status = 0;
    this.ActionUser = null;
  }

  public String getUserId() {
    return this.UserId;
  }

  public FriendLists setUserId(String UserId) {
    this.UserId = UserId;
    return this;
  }

  public void unsetUserId() {
    this.UserId = null;
  }

  /** Returns true if field UserId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return this.UserId != null;
  }

  public void setUserIdIsSet(boolean value) {
    if (!value) {
      this.UserId = null;
    }
  }

  public int getStatus() {
    return this.Status;
  }

  public FriendLists setStatus(int Status) {
    this.Status = Status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field Status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getActionUser() {
    return this.ActionUser;
  }

  public FriendLists setActionUser(String ActionUser) {
    this.ActionUser = ActionUser;
    return this;
  }

  public void unsetActionUser() {
    this.ActionUser = null;
  }

  /** Returns true if field ActionUser is set (has been assigned a value) and false otherwise */
  public boolean isSetActionUser() {
    return this.ActionUser != null;
  }

  public void setActionUserIsSet(boolean value) {
    if (!value) {
      this.ActionUser = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case ACTION_USER:
      if (value == null) {
        unsetActionUser();
      } else {
        setActionUser((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return getUserId();

    case STATUS:
      return getStatus();

    case ACTION_USER:
      return getActionUser();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case STATUS:
      return isSetStatus();
    case ACTION_USER:
      return isSetActionUser();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FriendLists)
      return this.equals((FriendLists)that);
    return false;
  }

  public boolean equals(FriendLists that) {
    if (that == null)
      return false;

    boolean this_present_UserId = true && this.isSetUserId();
    boolean that_present_UserId = true && that.isSetUserId();
    if (this_present_UserId || that_present_UserId) {
      if (!(this_present_UserId && that_present_UserId))
        return false;
      if (!this.UserId.equals(that.UserId))
        return false;
    }

    boolean this_present_Status = true;
    boolean that_present_Status = true;
    if (this_present_Status || that_present_Status) {
      if (!(this_present_Status && that_present_Status))
        return false;
      if (this.Status != that.Status)
        return false;
    }

    boolean this_present_ActionUser = true && this.isSetActionUser();
    boolean that_present_ActionUser = true && that.isSetActionUser();
    if (this_present_ActionUser || that_present_ActionUser) {
      if (!(this_present_ActionUser && that_present_ActionUser))
        return false;
      if (!this.ActionUser.equals(that.ActionUser))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_UserId = true && (isSetUserId());
    list.add(present_UserId);
    if (present_UserId)
      list.add(UserId);

    boolean present_Status = true;
    list.add(present_Status);
    if (present_Status)
      list.add(Status);

    boolean present_ActionUser = true && (isSetActionUser());
    list.add(present_ActionUser);
    if (present_ActionUser)
      list.add(ActionUser);

    return list.hashCode();
  }

  @Override
  public int compareTo(FriendLists other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.UserId, other.UserId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Status, other.Status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetActionUser()).compareTo(other.isSetActionUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActionUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ActionUser, other.ActionUser);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FriendLists(");
    boolean first = true;

    sb.append("UserId:");
    if (this.UserId == null) {
      sb.append("null");
    } else {
      sb.append(this.UserId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Status:");
    sb.append(this.Status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("ActionUser:");
    if (this.ActionUser == null) {
      sb.append("null");
    } else {
      sb.append(this.ActionUser);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FriendListsStandardSchemeFactory implements SchemeFactory {
    public FriendListsStandardScheme getScheme() {
      return new FriendListsStandardScheme();
    }
  }

  private static class FriendListsStandardScheme extends StandardScheme<FriendLists> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FriendLists struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.UserId = iprot.readString();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACTION_USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ActionUser = iprot.readString();
              struct.setActionUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FriendLists struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.UserId != null) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeString(struct.UserId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.Status);
      oprot.writeFieldEnd();
      if (struct.ActionUser != null) {
        oprot.writeFieldBegin(ACTION_USER_FIELD_DESC);
        oprot.writeString(struct.ActionUser);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FriendListsTupleSchemeFactory implements SchemeFactory {
    public FriendListsTupleScheme getScheme() {
      return new FriendListsTupleScheme();
    }
  }

  private static class FriendListsTupleScheme extends TupleScheme<FriendLists> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FriendLists struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUserId()) {
        optionals.set(0);
      }
      if (struct.isSetStatus()) {
        optionals.set(1);
      }
      if (struct.isSetActionUser()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetUserId()) {
        oprot.writeString(struct.UserId);
      }
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.Status);
      }
      if (struct.isSetActionUser()) {
        oprot.writeString(struct.ActionUser);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FriendLists struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.UserId = iprot.readString();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.Status = iprot.readI32();
        struct.setStatusIsSet(true);
      }
      if (incoming.get(2)) {
        struct.ActionUser = iprot.readString();
        struct.setActionUserIsSet(true);
      }
    }
  }

}

