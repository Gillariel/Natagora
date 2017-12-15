<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * HistoryNewMedia Entity
 *
 * @property int $Number
 * @property string $Month
 * @property \Cake\I18n\FrozenTime $Creation_Date
 * @property int $Has_Been_Pended
 */
class HistoryNewMedia extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array
     */
    protected $_accessible = [
        'Number' => true,
        'Month' => true,
        'Creation_Date' => true,
        'Has_Been_Pended' => true
    ];
}
