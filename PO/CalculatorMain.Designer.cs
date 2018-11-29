namespace Calculator
{
    partial class CalculatorMain
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CalculatorMain));
            this.btnSqrt = new System.Windows.Forms.Button();
            this.btnPow = new System.Windows.Forms.Button();
            this.btnSin = new System.Windows.Forms.Button();
            this.btnLog = new System.Windows.Forms.Button();
            this.btnNum7 = new System.Windows.Forms.Button();
            this.btnNum8 = new System.Windows.Forms.Button();
            this.btnNum9 = new System.Windows.Forms.Button();
            this.btnDiv = new System.Windows.Forms.Button();
            this.btnNum4 = new System.Windows.Forms.Button();
            this.btnNum5 = new System.Windows.Forms.Button();
            this.btnNum6 = new System.Windows.Forms.Button();
            this.btnMul = new System.Windows.Forms.Button();
            this.btnSub = new System.Windows.Forms.Button();
            this.btnNum3 = new System.Windows.Forms.Button();
            this.btnNum2 = new System.Windows.Forms.Button();
            this.btnNum1 = new System.Windows.Forms.Button();
            this.btnNum0 = new System.Windows.Forms.Button();
            this.btnDecimal = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.btnEq = new System.Windows.Forms.Button();
            this.btnC = new System.Windows.Forms.Button();
            this.btnCE = new System.Windows.Forms.Button();
            this.btnMod = new System.Windows.Forms.Button();
            this.btnExp = new System.Windows.Forms.Button();
            this.btnFi = new System.Windows.Forms.Button();
            this.btnPi = new System.Windows.Forms.Button();
            this.btnE = new System.Windows.Forms.Button();
            this.btnAbs = new System.Windows.Forms.Button();
            this.textBoxRes = new System.Windows.Forms.TextBox();
            this.labelCurrentExpr = new System.Windows.Forms.Label();
            this.btnCos = new System.Windows.Forms.Button();
            this.btnOpo = new System.Windows.Forms.Button();
            this.btnVarX = new System.Windows.Forms.Button();
            this.btnVarZ = new System.Windows.Forms.Button();
            this.btnVarY = new System.Windows.Forms.Button();
            this.labelVarsInfo = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnSqrt
            // 
            this.btnSqrt.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnSqrt.Location = new System.Drawing.Point(12, 229);
            this.btnSqrt.Name = "btnSqrt";
            this.btnSqrt.Size = new System.Drawing.Size(40, 40);
            this.btnSqrt.TabIndex = 0;
            this.btnSqrt.Text = "√a";
            this.btnSqrt.UseVisualStyleBackColor = true;
            this.btnSqrt.Click += new System.EventHandler(this.btnSqrtOp_Click);
            // 
            // btnPow
            // 
            this.btnPow.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.btnPow.Location = new System.Drawing.Point(104, 91);
            this.btnPow.Name = "btnPow";
            this.btnPow.Size = new System.Drawing.Size(40, 40);
            this.btnPow.TabIndex = 1;
            this.btnPow.Text = "a^n";
            this.btnPow.UseVisualStyleBackColor = true;
            this.btnPow.Click += new System.EventHandler(this.btnPowOp_Click);
            // 
            // btnSin
            // 
            this.btnSin.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnSin.Location = new System.Drawing.Point(58, 137);
            this.btnSin.Name = "btnSin";
            this.btnSin.Size = new System.Drawing.Size(40, 40);
            this.btnSin.TabIndex = 2;
            this.btnSin.Text = "sin";
            this.btnSin.UseVisualStyleBackColor = true;
            this.btnSin.Click += new System.EventHandler(this.btnSin_Click);
            // 
            // btnLog
            // 
            this.btnLog.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnLog.Location = new System.Drawing.Point(12, 137);
            this.btnLog.Name = "btnLog";
            this.btnLog.Size = new System.Drawing.Size(40, 40);
            this.btnLog.TabIndex = 3;
            this.btnLog.Text = "log";
            this.btnLog.UseVisualStyleBackColor = true;
            this.btnLog.Click += new System.EventHandler(this.btnLog_Click);
            // 
            // btnNum7
            // 
            this.btnNum7.Location = new System.Drawing.Point(150, 91);
            this.btnNum7.Name = "btnNum7";
            this.btnNum7.Size = new System.Drawing.Size(40, 40);
            this.btnNum7.TabIndex = 4;
            this.btnNum7.Text = "7";
            this.btnNum7.UseVisualStyleBackColor = true;
            this.btnNum7.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum8
            // 
            this.btnNum8.Location = new System.Drawing.Point(196, 91);
            this.btnNum8.Name = "btnNum8";
            this.btnNum8.Size = new System.Drawing.Size(40, 40);
            this.btnNum8.TabIndex = 5;
            this.btnNum8.Text = "8";
            this.btnNum8.UseVisualStyleBackColor = true;
            this.btnNum8.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum9
            // 
            this.btnNum9.Location = new System.Drawing.Point(242, 91);
            this.btnNum9.Name = "btnNum9";
            this.btnNum9.Size = new System.Drawing.Size(40, 40);
            this.btnNum9.TabIndex = 6;
            this.btnNum9.Text = "9";
            this.btnNum9.UseVisualStyleBackColor = true;
            this.btnNum9.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnDiv
            // 
            this.btnDiv.Location = new System.Drawing.Point(288, 91);
            this.btnDiv.Name = "btnDiv";
            this.btnDiv.Size = new System.Drawing.Size(40, 40);
            this.btnDiv.TabIndex = 7;
            this.btnDiv.Text = "/";
            this.btnDiv.UseVisualStyleBackColor = true;
            this.btnDiv.Click += new System.EventHandler(this.btnClassicOp_Click);
            // 
            // btnNum4
            // 
            this.btnNum4.Location = new System.Drawing.Point(150, 137);
            this.btnNum4.Name = "btnNum4";
            this.btnNum4.Size = new System.Drawing.Size(40, 40);
            this.btnNum4.TabIndex = 8;
            this.btnNum4.Text = "4";
            this.btnNum4.UseVisualStyleBackColor = true;
            this.btnNum4.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum5
            // 
            this.btnNum5.Location = new System.Drawing.Point(196, 137);
            this.btnNum5.Name = "btnNum5";
            this.btnNum5.Size = new System.Drawing.Size(40, 40);
            this.btnNum5.TabIndex = 9;
            this.btnNum5.Text = "5";
            this.btnNum5.UseVisualStyleBackColor = true;
            this.btnNum5.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum6
            // 
            this.btnNum6.Location = new System.Drawing.Point(242, 137);
            this.btnNum6.Name = "btnNum6";
            this.btnNum6.Size = new System.Drawing.Size(40, 40);
            this.btnNum6.TabIndex = 10;
            this.btnNum6.Text = "6";
            this.btnNum6.UseVisualStyleBackColor = true;
            this.btnNum6.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnMul
            // 
            this.btnMul.Location = new System.Drawing.Point(288, 137);
            this.btnMul.Name = "btnMul";
            this.btnMul.Size = new System.Drawing.Size(40, 40);
            this.btnMul.TabIndex = 11;
            this.btnMul.Text = "*";
            this.btnMul.UseVisualStyleBackColor = true;
            this.btnMul.Click += new System.EventHandler(this.btnClassicOp_Click);
            // 
            // btnSub
            // 
            this.btnSub.Location = new System.Drawing.Point(288, 183);
            this.btnSub.Name = "btnSub";
            this.btnSub.Size = new System.Drawing.Size(40, 40);
            this.btnSub.TabIndex = 15;
            this.btnSub.Text = "-";
            this.btnSub.UseVisualStyleBackColor = true;
            this.btnSub.Click += new System.EventHandler(this.btnClassicOp_Click);
            // 
            // btnNum3
            // 
            this.btnNum3.Location = new System.Drawing.Point(242, 183);
            this.btnNum3.Name = "btnNum3";
            this.btnNum3.Size = new System.Drawing.Size(40, 40);
            this.btnNum3.TabIndex = 14;
            this.btnNum3.Text = "3";
            this.btnNum3.UseVisualStyleBackColor = true;
            this.btnNum3.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum2
            // 
            this.btnNum2.Location = new System.Drawing.Point(196, 183);
            this.btnNum2.Name = "btnNum2";
            this.btnNum2.Size = new System.Drawing.Size(40, 40);
            this.btnNum2.TabIndex = 13;
            this.btnNum2.Text = "2";
            this.btnNum2.UseVisualStyleBackColor = true;
            this.btnNum2.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum1
            // 
            this.btnNum1.Location = new System.Drawing.Point(150, 183);
            this.btnNum1.Name = "btnNum1";
            this.btnNum1.Size = new System.Drawing.Size(40, 40);
            this.btnNum1.TabIndex = 12;
            this.btnNum1.Text = "1";
            this.btnNum1.UseVisualStyleBackColor = true;
            this.btnNum1.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnNum0
            // 
            this.btnNum0.Location = new System.Drawing.Point(150, 229);
            this.btnNum0.Name = "btnNum0";
            this.btnNum0.Size = new System.Drawing.Size(86, 40);
            this.btnNum0.TabIndex = 16;
            this.btnNum0.Text = "0";
            this.btnNum0.UseVisualStyleBackColor = true;
            this.btnNum0.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnDecimal
            // 
            this.btnDecimal.Location = new System.Drawing.Point(242, 229);
            this.btnDecimal.Name = "btnDecimal";
            this.btnDecimal.Size = new System.Drawing.Size(40, 40);
            this.btnDecimal.TabIndex = 17;
            this.btnDecimal.Text = ",";
            this.btnDecimal.UseVisualStyleBackColor = true;
            this.btnDecimal.Click += new System.EventHandler(this.btnArg_Click);
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(288, 229);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(40, 40);
            this.btnAdd.TabIndex = 18;
            this.btnAdd.Text = "+";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnClassicOp_Click);
            // 
            // btnEq
            // 
            this.btnEq.Location = new System.Drawing.Point(334, 183);
            this.btnEq.Name = "btnEq";
            this.btnEq.Size = new System.Drawing.Size(40, 86);
            this.btnEq.TabIndex = 23;
            this.btnEq.Text = "=";
            this.btnEq.UseVisualStyleBackColor = true;
            this.btnEq.Click += new System.EventHandler(this.btnEq_Click);
            // 
            // btnC
            // 
            this.btnC.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnC.Location = new System.Drawing.Point(334, 137);
            this.btnC.Name = "btnC";
            this.btnC.Size = new System.Drawing.Size(40, 40);
            this.btnC.TabIndex = 21;
            this.btnC.Text = "C";
            this.btnC.UseVisualStyleBackColor = true;
            this.btnC.Click += new System.EventHandler(this.btnC_Click);
            // 
            // btnCE
            // 
            this.btnCE.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnCE.Location = new System.Drawing.Point(334, 91);
            this.btnCE.Name = "btnCE";
            this.btnCE.Size = new System.Drawing.Size(40, 40);
            this.btnCE.TabIndex = 20;
            this.btnCE.Text = "CE";
            this.btnCE.UseVisualStyleBackColor = true;
            this.btnCE.Click += new System.EventHandler(this.btnCE_Click);
            // 
            // btnMod
            // 
            this.btnMod.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.btnMod.Location = new System.Drawing.Point(58, 229);
            this.btnMod.Name = "btnMod";
            this.btnMod.Size = new System.Drawing.Size(40, 40);
            this.btnMod.TabIndex = 19;
            this.btnMod.Text = "mod";
            this.btnMod.UseVisualStyleBackColor = true;
            this.btnMod.Click += new System.EventHandler(this.btnMod_Click);
            // 
            // btnExp
            // 
            this.btnExp.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnExp.Location = new System.Drawing.Point(58, 91);
            this.btnExp.Name = "btnExp";
            this.btnExp.Size = new System.Drawing.Size(40, 40);
            this.btnExp.TabIndex = 28;
            this.btnExp.Text = "exp";
            this.btnExp.UseVisualStyleBackColor = true;
            this.btnExp.Click += new System.EventHandler(this.btnExp_Click);
            // 
            // btnFi
            // 
            this.btnFi.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnFi.Location = new System.Drawing.Point(104, 229);
            this.btnFi.Name = "btnFi";
            this.btnFi.Size = new System.Drawing.Size(40, 40);
            this.btnFi.TabIndex = 27;
            this.btnFi.Text = "fi";
            this.btnFi.UseVisualStyleBackColor = true;
            this.btnFi.Click += new System.EventHandler(this.btnFi_Click);
            // 
            // btnPi
            // 
            this.btnPi.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnPi.Location = new System.Drawing.Point(104, 137);
            this.btnPi.Name = "btnPi";
            this.btnPi.Size = new System.Drawing.Size(40, 40);
            this.btnPi.TabIndex = 26;
            this.btnPi.Text = "Pi";
            this.btnPi.UseVisualStyleBackColor = true;
            this.btnPi.Click += new System.EventHandler(this.btnPi_Click);
            // 
            // btnE
            // 
            this.btnE.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.btnE.Location = new System.Drawing.Point(104, 183);
            this.btnE.Name = "btnE";
            this.btnE.Size = new System.Drawing.Size(40, 40);
            this.btnE.TabIndex = 25;
            this.btnE.Text = "e";
            this.btnE.UseVisualStyleBackColor = true;
            this.btnE.Click += new System.EventHandler(this.btnE_Click);
            // 
            // btnAbs
            // 
            this.btnAbs.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnAbs.Location = new System.Drawing.Point(12, 91);
            this.btnAbs.Name = "btnAbs";
            this.btnAbs.Size = new System.Drawing.Size(40, 40);
            this.btnAbs.TabIndex = 24;
            this.btnAbs.Text = "abs";
            this.btnAbs.UseVisualStyleBackColor = true;
            this.btnAbs.Click += new System.EventHandler(this.btnAbs_Click);
            // 
            // textBoxRes
            // 
            this.textBoxRes.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.textBoxRes.Location = new System.Drawing.Point(12, 36);
            this.textBoxRes.Name = "textBoxRes";
            this.textBoxRes.Size = new System.Drawing.Size(362, 32);
            this.textBoxRes.TabIndex = 29;
            this.textBoxRes.Text = "0";
            this.textBoxRes.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // labelCurrentExpr
            // 
            this.labelCurrentExpr.AutoSize = true;
            this.labelCurrentExpr.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F);
            this.labelCurrentExpr.ForeColor = System.Drawing.SystemColors.ControlDark;
            this.labelCurrentExpr.Location = new System.Drawing.Point(12, 9);
            this.labelCurrentExpr.Name = "labelCurrentExpr";
            this.labelCurrentExpr.Size = new System.Drawing.Size(0, 16);
            this.labelCurrentExpr.TabIndex = 30;
            // 
            // btnCos
            // 
            this.btnCos.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnCos.Location = new System.Drawing.Point(58, 182);
            this.btnCos.Name = "btnCos";
            this.btnCos.Size = new System.Drawing.Size(40, 40);
            this.btnCos.TabIndex = 31;
            this.btnCos.Text = "cos";
            this.btnCos.UseVisualStyleBackColor = true;
            this.btnCos.Click += new System.EventHandler(this.btnCos_Click);
            // 
            // btnOpo
            // 
            this.btnOpo.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnOpo.Location = new System.Drawing.Point(12, 182);
            this.btnOpo.Name = "btnOpo";
            this.btnOpo.Size = new System.Drawing.Size(40, 40);
            this.btnOpo.TabIndex = 32;
            this.btnOpo.Text = "-a";
            this.btnOpo.UseVisualStyleBackColor = true;
            this.btnOpo.Click += new System.EventHandler(this.btnOpposite_Click);
            // 
            // btnVarX
            // 
            this.btnVarX.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnVarX.Location = new System.Drawing.Point(104, 275);
            this.btnVarX.Name = "btnVarX";
            this.btnVarX.Size = new System.Drawing.Size(86, 40);
            this.btnVarX.TabIndex = 33;
            this.btnVarX.Text = "x";
            this.btnVarX.UseVisualStyleBackColor = true;
            this.btnVarX.Click += new System.EventHandler(this.btnVar_Click);
            // 
            // btnVarZ
            // 
            this.btnVarZ.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnVarZ.Location = new System.Drawing.Point(288, 275);
            this.btnVarZ.Name = "btnVarZ";
            this.btnVarZ.Size = new System.Drawing.Size(86, 40);
            this.btnVarZ.TabIndex = 35;
            this.btnVarZ.Text = "z";
            this.btnVarZ.UseVisualStyleBackColor = true;
            this.btnVarZ.Click += new System.EventHandler(this.btnVar_Click);
            // 
            // btnVarY
            // 
            this.btnVarY.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnVarY.Location = new System.Drawing.Point(196, 275);
            this.btnVarY.Name = "btnVarY";
            this.btnVarY.Size = new System.Drawing.Size(86, 40);
            this.btnVarY.TabIndex = 34;
            this.btnVarY.Text = "y";
            this.btnVarY.UseVisualStyleBackColor = true;
            this.btnVarY.Click += new System.EventHandler(this.btnVar_Click);
            // 
            // labelVarsInfo
            // 
            this.labelVarsInfo.AutoSize = true;
            this.labelVarsInfo.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.labelVarsInfo.Location = new System.Drawing.Point(12, 287);
            this.labelVarsInfo.Name = "labelVarsInfo";
            this.labelVarsInfo.Size = new System.Drawing.Size(71, 17);
            this.labelVarsInfo.TabIndex = 36;
            this.labelVarsInfo.Text = "Variables:";
            // 
            // CalculatorMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(389, 328);
            this.Controls.Add(this.labelVarsInfo);
            this.Controls.Add(this.btnVarZ);
            this.Controls.Add(this.btnVarY);
            this.Controls.Add(this.btnVarX);
            this.Controls.Add(this.btnOpo);
            this.Controls.Add(this.btnCos);
            this.Controls.Add(this.labelCurrentExpr);
            this.Controls.Add(this.textBoxRes);
            this.Controls.Add(this.btnExp);
            this.Controls.Add(this.btnFi);
            this.Controls.Add(this.btnPi);
            this.Controls.Add(this.btnE);
            this.Controls.Add(this.btnAbs);
            this.Controls.Add(this.btnEq);
            this.Controls.Add(this.btnC);
            this.Controls.Add(this.btnCE);
            this.Controls.Add(this.btnMod);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.btnDecimal);
            this.Controls.Add(this.btnNum0);
            this.Controls.Add(this.btnSub);
            this.Controls.Add(this.btnNum3);
            this.Controls.Add(this.btnNum2);
            this.Controls.Add(this.btnNum1);
            this.Controls.Add(this.btnMul);
            this.Controls.Add(this.btnNum6);
            this.Controls.Add(this.btnNum5);
            this.Controls.Add(this.btnNum4);
            this.Controls.Add(this.btnDiv);
            this.Controls.Add(this.btnNum9);
            this.Controls.Add(this.btnNum8);
            this.Controls.Add(this.btnNum7);
            this.Controls.Add(this.btnLog);
            this.Controls.Add(this.btnSin);
            this.Controls.Add(this.btnPow);
            this.Controls.Add(this.btnSqrt);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "CalculatorMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnSqrt;
        private System.Windows.Forms.Button btnPow;
        private System.Windows.Forms.Button btnSin;
        private System.Windows.Forms.Button btnLog;
        private System.Windows.Forms.Button btnNum7;
        private System.Windows.Forms.Button btnNum8;
        private System.Windows.Forms.Button btnNum9;
        private System.Windows.Forms.Button btnDiv;
        private System.Windows.Forms.Button btnNum4;
        private System.Windows.Forms.Button btnNum5;
        private System.Windows.Forms.Button btnNum6;
        private System.Windows.Forms.Button btnMul;
        private System.Windows.Forms.Button btnSub;
        private System.Windows.Forms.Button btnNum3;
        private System.Windows.Forms.Button btnNum2;
        private System.Windows.Forms.Button btnNum1;
        private System.Windows.Forms.Button btnNum0;
        private System.Windows.Forms.Button btnDecimal;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnEq;
        private System.Windows.Forms.Button btnC;
        private System.Windows.Forms.Button btnCE;
        private System.Windows.Forms.Button btnMod;
        private System.Windows.Forms.Button btnExp;
        private System.Windows.Forms.Button btnFi;
        private System.Windows.Forms.Button btnPi;
        private System.Windows.Forms.Button btnE;
        private System.Windows.Forms.Button btnAbs;
        private System.Windows.Forms.TextBox textBoxRes;
        private System.Windows.Forms.Label labelCurrentExpr;
        private System.Windows.Forms.Button btnCos;
        private System.Windows.Forms.Button btnOpo;
        private System.Windows.Forms.Button btnVarX;
        private System.Windows.Forms.Button btnVarZ;
        private System.Windows.Forms.Button btnVarY;
        private System.Windows.Forms.Label labelVarsInfo;
    }
}

