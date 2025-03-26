<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='jinronggongju'">
                    <el-form-item class="select" v-if="type!='info'"  label="金融工具" prop="jinronggongjuId">
                        <el-select v-model="ruleForm.jinronggongjuId" :disabled="ro.jinronggongjuId" filterable placeholder="请选择金融工具" @change="jinronggongjuChange">
                            <el-option
                                    v-for="(item,index) in jinronggongjuOptions"
                                    v-bind:key="item.id"
                                    :label="item.jinronggongjuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jinronggongju' ">
                    <el-form-item class="input" v-if="type!='info'"  label="产品名称" prop="jinronggongjuName">
                        <el-input v-model="jinronggongjuForm.jinronggongjuName"
                                  placeholder="产品名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="产品名称" prop="jinronggongjuName">
                            <el-input v-model="ruleForm.jinronggongjuName"
                                      placeholder="产品名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='jinronggongju' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jinronggongjuPhoto" label="产品照片" prop="jinronggongjuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (jinronggongjuForm.jinronggongjuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jinronggongjuPhoto" label="产品照片" prop="jinronggongjuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.jinronggongjuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jinronggongju' ">
                    <el-form-item class="input" v-if="type!='info'"  label="产品类型" prop="jinronggongjuValue">
                        <el-input v-model="jinronggongjuForm.jinronggongjuValue"
                                  placeholder="产品类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="产品类型" prop="jinronggongjuValue">
                            <el-input v-model="ruleForm.jinronggongjuValue"
                                      placeholder="产品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka'">
                    <el-form-item class="select" v-if="type!='info'"  label="银行卡" prop="yinhangkaId">
                        <el-select v-model="ruleForm.yinhangkaId" :disabled="ro.yinhangkaId" filterable placeholder="请选择银行卡" @change="yinhangkaChange">
                            <el-option
                                    v-for="(item,index) in yinhangkaOptions"
                                    v-bind:key="item.id"
                                    :label="item.yinhangkaUuidNumber"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="银行卡卡号" prop="yinhangkaUuidNumber">
                        <el-input v-model="yinhangkaForm.yinhangkaUuidNumber"
                                  placeholder="银行卡卡号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="银行卡卡号" prop="yinhangkaUuidNumber">
                            <el-input v-model="ruleForm.yinhangkaUuidNumber"
                                      placeholder="银行卡卡号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yinhangkaPhoto" label="银行卡照片" prop="yinhangkaPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yinhangkaForm.yinhangkaPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yinhangkaPhoto" label="银行卡照片" prop="yinhangkaPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yinhangkaPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="开卡地" prop="yinhangkaKaikadi">
                        <el-input v-model="yinhangkaForm.yinhangkaKaikadi"
                                  placeholder="开卡地" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="开卡地" prop="yinhangkaKaikadi">
                            <el-input v-model="ruleForm.yinhangkaKaikadi"
                                      placeholder="开卡地" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="银行" prop="yinhangValue">
                        <el-input v-model="yinhangkaForm.yinhangValue"
                                  placeholder="银行" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="银行" prop="yinhangValue">
                            <el-input v-model="ruleForm.yinhangValue"
                                      placeholder="银行" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="银行卡类型" prop="yinhangkaValue">
                        <el-input v-model="yinhangkaForm.yinhangkaValue"
                                  placeholder="银行卡类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="银行卡类型" prop="yinhangkaValue">
                            <el-input v-model="ruleForm.yinhangkaValue"
                                      placeholder="银行卡类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="编码" prop="yinhangkaAddress">
                        <el-input v-model="yinhangkaForm.yinhangkaAddress"
                                  placeholder="编码" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="编码" prop="yinhangkaAddress">
                            <el-input v-model="ruleForm.yinhangkaAddress"
                                      placeholder="编码" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yinhangka' ">
                    <el-form-item class="input" v-if="type!='info'"  label="余额" prop="yinhangkaMoney">
                        <el-input v-model="yinhangkaForm.yinhangkaMoney"
                                  placeholder="余额" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="余额" prop="yinhangkaMoney">
                            <el-input v-model="ruleForm.yinhangkaMoney"
                                      placeholder="余额" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="jinronggongjuOrderUuidNumber">
                       <el-input v-model="ruleForm.jinronggongjuOrderUuidNumber"
                                 placeholder="订单编号" clearable  :readonly="ro.jinronggongjuOrderUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="订单编号" prop="jinronggongjuOrderUuidNumber">
                           <el-input v-model="ruleForm.jinronggongjuOrderUuidNumber"
                                     placeholder="订单编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="jinronggongjuId" name="jinronggongjuId" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="yinhangkaId" name="yinhangkaId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="借款金额" prop="jinronggongjuOrderJiekuanjine">
                       <el-input v-model="ruleForm.jinronggongjuOrderJiekuanjine"
                                 placeholder="借款金额" clearable  :readonly="ro.jinronggongjuOrderJiekuanjine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="借款金额" prop="jinronggongjuOrderJiekuanjine">
                           <el-input v-model="ruleForm.jinronggongjuOrderJiekuanjine"
                                     placeholder="借款金额" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="还款金额" prop="jinronggongjuOrderHuankuanjine">
                       <el-input v-model="ruleForm.jinronggongjuOrderHuankuanjine"
                                 placeholder="还款金额" clearable  :readonly="ro.jinronggongjuOrderHuankuanjine"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="还款金额" prop="jinronggongjuOrderHuankuanjine">
                           <el-input v-model="ruleForm.jinronggongjuOrderHuankuanjine"
                                     placeholder="还款金额" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info' && !ro.zuiwanhuankuanTime"  class="input" label="最晚还款日期" prop="zuiwanhuankuanTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.zuiwanhuankuanTime"
                                type="datetime"
                                placeholder="最晚还款日期"
                                :disabled="ro.zuiwanhuankuanTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zuiwanhuankuanTime" label="最晚还款日期" prop="zuiwanhuankuanTime">
                            <span v-html="ruleForm.zuiwanhuankuanTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="订单类型" prop="jinronggongjuOrderTypes">
                        <el-select v-model="ruleForm.jinronggongjuOrderTypes" :disabled="ro.jinronggongjuOrderTypes" placeholder="请选择订单类型">
                            <el-option
                                v-for="(item,index) in jinronggongjuOrderTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="订单类型" prop="jinronggongjuOrderValue">
                        <el-input v-model="ruleForm.jinronggongjuOrderValue"
                            placeholder="订单类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="支付类型" prop="jinronggongjuOrderPaymentTypes">
                        <el-select v-model="ruleForm.jinronggongjuOrderPaymentTypes" :disabled="ro.jinronggongjuOrderPaymentTypes" placeholder="请选择支付类型">
                            <el-option
                                v-for="(item,index) in jinronggongjuOrderPaymentTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="支付类型" prop="jinronggongjuOrderPaymentValue">
                        <el-input v-model="ruleForm.jinronggongjuOrderPaymentValue"
                            placeholder="支付类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jinronggongjuOrderYesnoTypes" label="审核状态" prop="jinronggongjuOrderYesnoTypes">
                        <el-input v-model="ruleForm.jinronggongjuOrderYesnoValue" placeholder="审核状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jinronggongjuOrderYesnoText" label="审核意见" prop="jinronggongjuOrderYesnoText">
                        <span v-html="ruleForm.jinronggongjuOrderYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jinronggongjuOrderShenheTime" label="审核时间" prop="jinronggongjuOrderShenheTime">
                        <span v-html="ruleForm.jinronggongjuOrderShenheTime"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                jinronggongjuForm: {},
                yinhangkaForm: {},
                yonghuForm: {},
                ro:{
                    jinronggongjuOrderUuidNumber: true,
                    jinronggongjuId: false,
                    yonghuId: false,
                    yinhangkaId: false,
                    jinronggongjuOrderJiekuanjine: false,
                    jinronggongjuOrderHuankuanjine: false,
                    zuiwanhuankuanTime: false,
                    jinronggongjuOrderTypes: false,
                    jinronggongjuOrderPaymentTypes: false,
                    jinronggongjuOrderYesnoTypes: false,
                    jinronggongjuOrderYesnoText: false,
                    jinronggongjuOrderShenheTime: false,
                    insertTime: false,
                },
                ruleForm: {
                    jinronggongjuOrderUuidNumber: new Date().getTime(),
                    jinronggongjuId: '',
                    yonghuId: '',
                    yinhangkaId: '',
                    jinronggongjuOrderJiekuanjine: '',
                    jinronggongjuOrderHuankuanjine: '',
                    zuiwanhuankuanTime: '',
                    jinronggongjuOrderTypes: '',
                    jinronggongjuOrderPaymentTypes: '',
                    jinronggongjuOrderYesnoTypes: '',
                    jinronggongjuOrderYesnoText: '',
                    jinronggongjuOrderShenheTime: '',
                    insertTime: '',
                },
                jinronggongjuOrderTypesOptions : [],
                jinronggongjuOrderPaymentTypesOptions : [],
                jinronggongjuOrderYesnoTypesOptions : [],
                jinronggongjuOptions : [],
                yinhangkaOptions : [],
                yonghuOptions : [],
                rules: {
                   jinronggongjuOrderUuidNumber: [
                              { required: true, message: '订单编号不能为空', trigger: 'blur' },
                          ],
                   jinronggongjuId: [
                              { required: true, message: '金融工具不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yinhangkaId: [
                              { required: true, message: '银行卡不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jinronggongjuOrderJiekuanjine: [
                              { required: true, message: '借款金额不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   jinronggongjuOrderHuankuanjine: [
                              { required: true, message: '还款金额不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   zuiwanhuankuanTime: [
                              { required: true, message: '最晚还款日期不能为空', trigger: 'blur' },
                          ],
                   jinronggongjuOrderTypes: [
                              { required: true, message: '订单类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jinronggongjuOrderPaymentTypes: [
                              { required: true, message: '支付类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jinronggongjuOrderYesnoTypes: [
                              { required: true, message: '审核状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jinronggongjuOrderYesnoText: [
                              { required: true, message: '审核意见不能为空', trigger: 'blur' },
                          ],
                   jinronggongjuOrderShenheTime: [
                              { required: true, message: '审核时间不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '订单创建时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jinronggongju_order_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jinronggongjuOrderTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jinronggongju_order_payment_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jinronggongjuOrderPaymentTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jinronggongju_order_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jinronggongjuOrderYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `jinronggongju/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jinronggongjuOptions = data.data.list;
            }
         });
         this.$http({
             url: `yinhangka/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yinhangkaOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            jinronggongjuChange(id){
                this.$http({
                    url: `jinronggongju/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jinronggongjuForm = data.data;
                    }
                });
            },
            yinhangkaChange(id){
                this.$http({
                    url: `yinhangka/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yinhangkaForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `jinronggongjuOrder/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.jinronggongjuChange(data.data.jinronggongjuId)
                        _this.yinhangkaChange(data.data.yinhangkaId)
                        _this.yonghuChange(data.data.yonghuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`jinronggongjuOrder/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.jinronggongjuOrderCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.jinronggongjuOrderCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

