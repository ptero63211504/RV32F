package Pipeline

import chisel3._
import chisel3.util._

class MEM_WB extends Module {
  val io = IO(new Bundle {
    val EXMEM_MEMTOREG      = Input(Bool())
    val EXMEM_REG_W         = Input(Bool())
    val EXMEM_MEMRD         = Input(Bool())
    val EXMEM_rd            = Input(UInt(5.W))
    val in_dataMem_out      = Input(SInt(32.W))
    val in_alu_out          = Input(SInt(32.W))
    //RV32F
    val in_fpu_out          = Input(SInt(32.W))
    val EXMEM_fp_en         = Input(bool())

    val MEMWB_memToReg_out  = Output(Bool())
    val MEMWB_reg_w_out     = Output(Bool())
    val MEMWB_memRd_out     = Output(Bool())
    val MEMWB_rd_out        = Output(UInt(5.W))
    val MEMWB_dataMem_out   = Output(SInt(32.W))
    val MEMWB_alu_out       = Output(SInt(32.W))
    //RV32F
    val MEMWB_fpu_out       = Output(SInt(32.W))
    val MEMWB_fp_en         = Output(bool())
  })

  io.MEMWB_memToReg_out     := RegNext(io.EXMEM_MEMTOREG)
  io.MEMWB_reg_w_out        := RegNext(io.EXMEM_REG_W)
  io.MEMWB_memRd_out        := RegNext(io.EXMEM_MEMRD)
  io.MEMWB_rd_out           := RegNext(io.EXMEM_rd)
  io.MEMWB_dataMem_out      := RegNext(io.in_dataMem_out)
  io.MEMWB_alu_out          := RegNext(io.in_alu_out)
  //RV32F
  io.MEMWB_fpu_out          := RegNext(io.in_fpu_out)
  io.MEMWB_fp_en            := RegNext(io.EXMEM_fp_en)
}
