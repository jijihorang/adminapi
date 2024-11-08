package org.oz.adminapi.common.domain;


public enum BasicStatus {
    PENDING {
        @Override
        public BasicStatus changeStatus(int num) {
            return PENDING;
        }
    },
    ACCEPTED {
        @Override
        public BasicStatus changeStatus(int num) {
            return ACCEPTED;
        }
    },
    REJECTED {
        @Override
        public BasicStatus changeStatus(int num) {
            return REJECTED;
        }
    },
    DELIVERED {
        @Override
        public BasicStatus changeStatus(int num) {
            throw new UnsupportedOperationException("DELIVERED 상태 이후로는 변경할 수 없습니다.");
        }
    };


    public abstract BasicStatus changeStatus(int num){};
}
