package com.songbo.server.mapper;

import com.songbo.server.entity.Address;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AddressMapper extends Mapper<Address> {

    List<Address> getAddrsByAccountId(int id);
}