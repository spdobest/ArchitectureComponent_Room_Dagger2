package spm.component_room_paging_dagger2.paging.paging_lib.network;

public interface RetrofitResponseListener {
    public void onResponse(Object object, int apiTag);
    public void onError(String error);
}
