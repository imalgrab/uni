using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Abs : UnaryOperation
    {
        public double value;

        public Abs(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return Math.Abs(value);
        }

        public override string Result()
        {
            return $"abs({value}";
        }
    }
}
