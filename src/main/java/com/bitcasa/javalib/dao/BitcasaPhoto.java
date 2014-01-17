package com.bitcasa.javalib.dao;

public class BitcasaPhoto extends BitcasaFile {

    @Override
    public String toString() {
        return "BitcasaPhoto [mAlbum=" + mAlbum + ", mExtension=" + mExtension
                + ", mManifestName=" + mManifestName + ", mMime=" + mMime
                + ", mId=" + mId + ", mIncomplete=" + mIncomplete + ", mSize="
                + mSize + ", mCategory=" + mCategory + ", mType=" + mType
                + ", mName=" + mName + ", mPath=" + mPath + ", mModifiedTime="
                + mModifiedTime + ", mMirrored=" + mMirrored + ", mMountPoint="
                + mMountPoint + ", mDeleted=" + mDeleted + ", mOriginDevice="
                + mOriginDevice + ", mOriginDeviceId=" + mOriginDeviceId
                + ", mSyncType=" + mSyncType + "]";
    }

}
